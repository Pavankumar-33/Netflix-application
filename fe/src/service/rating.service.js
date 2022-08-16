import axios from 'axios'

export const rateme = async(value) => {
    var usernameStore = sessionStorage.getItem("username");
	try {
        const header = {
            'Content-Type': 'application/json',
        }
        var commentTitle = value.title
        var rating = value.status
        var data = {commentTitle,rating,usernameStore }
        await axios.post(`/node/rating/rate`, data, {header});
    } catch (e) {
        throw e;
    }

}