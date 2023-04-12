import axios from 'axios';

const http = axios.create({
    baseURL: "http://localhost:9000"
});

export default {
    getAllDoctors() {
        return http.get('/doctors');
    },

    get(id) {
        return http.get(`/doctors/${id}`);
    }
}