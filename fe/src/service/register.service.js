import axios from 'axios'

export const postUserData = async(value) => {
	try {
        const header = {
            'Content-Type': 'application/json',
        }
        await axios.post(`/java/users`, value, {header});
    } catch (e) {
        throw e;
    }
}