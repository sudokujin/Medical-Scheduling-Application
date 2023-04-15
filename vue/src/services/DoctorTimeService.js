import axios from 'axios';

const http = axios.create({
    baseURL: "http://localhost:9000"
});

export default {
    getTime(id) {
        return http.get(`/time/${id}`);
    },
    getAllTimeSlots() {
        return http.get(`/time`);
    }
}