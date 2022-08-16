import axios from 'axios'

export const getMovies = async(movieType) => {
    const responseMovies =  await axios.get(`/java/movies/${movieType}`)
    return responseMovies
}