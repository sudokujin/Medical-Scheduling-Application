import axios from 'axios';

const http = axios.create({
    baseURL: "http://localhost:9000"
});

export default {
    getPatientList() {
        return http.get('/patients');
    },

    get(id) {
        return http.get(`/patients/${id}`);
    },
    
    update(id, patient) {
        return http.put(`/patients/${id}`, patient);
    },

    delete(id) {
        return http.delete(`/patients/${id}`);
    },

    create(patient) {
        return http.post(`/patients`, patient);
    },

    getMaxId() {
        return http.get(`/patients/maxId`)
    }
}