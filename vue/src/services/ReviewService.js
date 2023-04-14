import axios from 'axios';
const http = axios.create({
    baseURL:"http://localhost:9000"
});

export default {
    getReviewByPatientId(id) {
        return http.get(`/reviews/${id}`);
    },
    getAllReviews() {
        return http.get('/reviews');
    },
    createReview(review) {
        return http.post('/reviews', review);
    },
    deleteReview(id) {
        return http.delete(`/reviews/${id}`)
    }
}