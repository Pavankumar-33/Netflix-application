import axios from 'axios'

export const postLoginData = async(value) => {
    let data = ""
	try {
        const header = {
            'Content-Type': 'application/json',
        }
        await axios.post(`/java/checkuser`, value, {header})
        .then(function (response) {
            data = value.username
        })
        .catch(function (error) {
            data= 500
        });
    } catch (e) {
        data= 500
    }
    return data
}