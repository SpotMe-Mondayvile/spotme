import axios from "axios";

const API_URL = import.meta.env.VITE_REST_ORIGIN

export default axios.create({
    baseURL: API_URL
})

