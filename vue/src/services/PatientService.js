import axios from 'axios';

const http = axios.create({
    baseURL: "http://localhost:8080"
});

export default {
    list() {
        return http.get('/patients');
    },

    get(id) {
        return http.get(`/patients/${id}`);
    }
}