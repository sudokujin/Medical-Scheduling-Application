import axios from 'axios';

/* eslint-disable */
var userId = 5;

const http = axios.create({
    baseURL: "http://localhost:9000"
});

export default {
    getPatientList() {
        return http.get('/patients');
    },
    get(id) {
        return http.get(`/patients/user/${id}`)
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
    async getMaxId() {
        let config = {
            headers: {
                'Accept': 'application/json'
            }
        }
        const response = await axios.get('http://localhost:9000/patients/maxId', config)
        this.response = JSON.parse(response.data.userId);
        console.log(this.response);
        return this.response
    },
    getUserName() {
        return http.get(`/patients/currentUserName`);
    }
}