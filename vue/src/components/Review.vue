<template>
    <v-container>
        <nav-bar />
        <div class="main">
            <h2>Reviews for {{ this.doctorName }}</h2>
            <p class="description">{{ this.title }}</p>

                <div class="well-display">
                   

                    <div class="well">
                        <span class="amount" v-on:click="filter = 1">{{ numberOfOneStarReviews }}</span>
                        1 Star Review{{ numberOfOneStarReviews === 1 ? '' : 's' }}
                    </div>

                    <div class="well">
                        <span class="amount" v-on:click="filter = 2">{{ numberOfTwoStarReviews }}</span>
                        2 Star Review{{ numberOfTwoStarReviews === 1 ? '' : 's' }}
                    </div>

                    <div class="well">
                        <span class="amount" v-on:click="filter = 3">{{ numberOfThreeStarReviews }}</span>
                        3 Star Review{{ numberOfThreeStarReviews === 1 ? '' : 's' }}
                    </div>

                    <div class="well">
                        <span class="amount" v-on:click="filter = 4">{{ numberOfFourStarReviews }}</span>
                        4 Star Review{{ numberOfFourStarReviews === 1 ? '' : 's' }}
                    </div>

                    <div class="well">
                        <span class="amount" v-on:click="filter = 5">{{ numberOfFiveStarReviews }}</span>
                        5 Star Review{{ numberOfFiveStarReviews === 1 ? '' : 's' }}
                    </div>
                </div>

                <a
                id="show-form-button"
                href="#"
                v-on:click.prevent="showForm = true"
                v-if="showForm === false"
                >Show Form</a
                >
                <v-col fill-height class="d-flex justify-start"> 
                <v-card>
                <v-form class="px-6 pb-5 pt-6" v-on:submit.prevent="addNewReview" v-if="showForm === true">
                <div class="form-element">
                    
                    <label for="reviewer">Name:</label>
                    <input id="reviewer" type="text" v-model="newReview.patientName" /> <!-- patient name here based on patient id -->
                </div>
                <div class="form-element">
                    <label for="title">Title:</label>
                    <input id="title" type="text" v-model="newReview.reviewTitle" /> <!-- review title here based on patient id/doc id/review id -->
                </div>
                <div class="form-element">
                    <label for="rating">Rating:</label>
                    <select id="rating" v-model.number="newReview.reviewRating">  <!-- review_rating based on patient id/doc id/review id -->
                    <option value="1">1 Star</option>
                    <option value="2">2 Stars</option>
                    <option value="3">3 Stars</option>
                    <option value="4">4 Stars</option>
                    <option value="5">5 Stars</option>
                    </select>
                </div>
                <div class="form-element">
                    <label for="review">Review:</label>
                    <textarea id="review" v-model="newReview.reviewBody"></textarea> <!-- review_body based on patient id/doc id/review id -->
                </div>
                <input type="submit" value="Save"> <!-- post to database review table on submit button being clicked -->
                <input type="button" value="Cancel" v-on:click="resetForm">
                </v-form>
                </v-card>
                </v-col>
                <div
                class="review"
                v-for="review in this.$store.state.reviews"  
                v-bind:key="review.id"
                > <!-- loop over review objects based on a filtered review list of doctors by id , do not need favorited section line 77-->
                <h4>{{ review.patientName }}</h4> <!-- patient name here based on patient id -->
                <div class="rating">
                    <img
                    src="../assets/star.png"
                    v-bind:title="review.reviewRating + ' Star Review'"
                    class="ratingStar"
                    v-for="n in review.reviewRating"
                    v-bind:key="n"
                    />
                </div>
                <h3>{{ review.reviewTitle }}</h3>

                <p>{{ review.reviewBody }}</p>

                </div>
            </div>
    </v-container>
</template>
<script>
import reviewService from '../services/ReviewService.js'
import navBar from './Navbar.vue'

export default {
    name: 'reviews',
    components: {
        navBar
    },
    data() {
        return {
            doctorName: '',
            doctorId: null,
            patientName: '',
            patientId: null,
            title: 'Research our doctors so you can make the best choice for your needs!',
            newReview: {},
            showForm: false,
            filter: 0,
            reviews: []
        }
    },
    methods: {
        getAllReviews() {
            reviewService.getAllReviews().then(response => {
                this.$store.commit("SET_REVIEWS", response.data);
            });
        },
        addNewReview() {
            reviewService.createReview(this.newReview).then(response => {
                if(response.status === 201) {
                    // this.$router.push('/reviews');
                    this.getAllReviews();
                }
            })
        },
        getReviewsByDoctor() {
            reviewService.getReviewsByDoctorId();
        },
        resetForm() {
            this.newReview = {};
             this.showForm = false;
        },
        numberOfReviews(numOfStars) {
            const reviewsWithNumStars = this.reviews.filter(
                (review) => review.reviewRating === numOfStars
            );
        return reviewsWithNumStars.length;
        }
    },
    computed: {
        averageRating() {
            let sum = this.reviews.reduce((currentSum, review) => {
                return currentSum + review.rating;
            }, 0);
            return (sum / this.reviews.length).toFixed(2);
        },
        numberOfOneStarReviews() {
            return this.numberOfReviews(1);
        },
        numberOfTwoStarReviews() {
            return this.numberOfReviews(2);
        },
        numberOfThreeStarReviews() {
            return this.numberOfReviews(3);
        },
        numberOfFourStarReviews() {
            return this.numberOfReviews(4);
        },
        numberOfFiveStarReviews() {
            return this.numberOfReviews(5);
        },
        filteredReviews() {
            // filtered reviews will grab review list, and filter through them based on the doctor id to display each doctors reviews
            // maybe I need a drop down menu like v-calendar to choose which doctor to see reviews for?? This way I can get the id and compare
            // to the review id
            return null;
        }
    },
    created() {
        this.getAllReviews();
        this.reviews = this.$store.state.reviews;
    }
}
</script>

<style scoped>
    div.main {
    margin: 1rem 0;
    }

    div.main div.well-display {
    display: flex;
    justify-content: space-around;
    margin-bottom: 1rem;
    }

    div.main div.well-display div.well {
    display: inline-block;
    width: 15%;
    border: 1px black solid;
    border-radius: 6px;
    text-align: center;
    margin: 0.25rem;
    padding: 0.25rem;
    }

    div.main div.well-display div.well span.amount {
    color: darkslategray;
    display: block;
    font-size: 2.5rem;
    }

    div.main div.review {
    border: 1px black solid;
    border-radius: 6px;
    padding: 1rem;
    margin: 10px;
    }

    div.main div.review.favorited {
    background-color: lightyellow;
    }

    div.main div.review div.rating {
    height: 2rem;
    display: inline-block;
    vertical-align: top;
    margin: 0 0.5rem;
    }

    div.main div.review div.rating img {
    height: 100%;
    }

    div.main div.review p {
    margin: 20px;
    }

    div.main div.review h3 {
    display: inline-block;
    }

    div.main div.review h4 {
    font-size: 1rem;
    }

    div.form-element {
    margin-top: 10px;
    }
    div.form-element > label {
    display: block;
    }
    div.form-element > input, div.form-element > select {
    height: 30px;
    width: 300px;
    }
    div.form-element > textarea {
    height: 60px;
    width: 300px;
    }
    form > input[type=button] {
    width: 100px;
    }
    form > input[type=submit] {
    width: 100px;
    margin-right: 10px;
    }
</style>