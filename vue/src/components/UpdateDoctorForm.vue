<template>
    <v-container fill-height fluid>
      <v-col align="center" justify="center" fill-height class="d-flex justify-center"> 
        <v-card>
        <div id="updateDoctor" class="text-center">
          <v-form class="px-6 pb-5 pt-6" ref="updateDoctorForm" id="userId" v-model="valid" @submit.prevent="updateDoctor();">
            <v-img class='mx-auto' src='../assets/caduceus-transparent-background-8.png'
            max-width='50px'
            max-height='100px'
            > </v-img>
            <h1>Enter Updated Information</h1>
            <v-text-field
                v-model="doctor.firstName"
                :rules="nameRules"
                :counter="50"
                label="First name"
                prepend-inner-icon="mdi-rename"
                required
              ></v-text-field>
            <v-text-field
              v-model="doctor.lastName"
              :rules="nameRules"
              :counter="50"
              label="Last name"
              prepend-inner-icon="mdi-rename"
              required
            ></v-text-field>
            <v-text-field
              v-model="doctor.specialty"
              :rules="nameRules"
              :counter="50"
              label="Specialty"
              prepend-inner-icon="mdi-account-star"
              required
            ></v-text-field>
            <v-text-field
              v-model="doctor.suiteNumber"
              :rules="nameRules"
              :counter="50"
              label="Suite Number"
              prepend-inner-icon="mdi-map-marker"
              required
            ></v-text-field>
            <v-text-field
              v-model="doctor.costPerHour"
              :rules="nameRules"
              :counter="50"
              label="Cost Per Hour"
              prepend-inner-icon="mdi-currency-usd"
              required
            ></v-text-field>
            <v-text-field
              v-model="doctor.phoneNumber"
              :rules="nameRules"
              :counter="50"
              label="Phone Number"
              prepend-inner-icon="mdi-phone"
              required
            ></v-text-field>
           

            <v-btn type="submit" :disabled="!valid">Submit Updated Information</v-btn>

    
            <v-btn @click="clearInput">
              Clear Fields
            </v-btn>
          </v-form>
        </div>
        </v-card>
      </v-col>
    </v-container>
</template>

<script>
import DoctorService from '../services/DoctorService'

  export default {
    name: "UpdateDoctorForm",
    data: () => ({
        doctor: {
            doctorId: 0,
            userId: 0,
            firstName: '',
            lastName: '',
            specialty: '',
            suiteNumber: '',
            costPerHour: '',
            phoneNumber: '',
        },
        registrationErrors: false,
        registrationErrorMsg: 'There were problems registering this user.',
        valid: false,
        nameRules: [
          value => {
            if (value) return true

            return 'Name is required.'
          },
          value => {
            if (value?.length <= 50) return true

            return 'Name must be less than or equal to 50 characters.'
          },
        ],
        emailRules: [
          value => {
            if (value) return true

            return 'E-mail is required.'
          },
          value => {
            if (/.+@.+\..+/.test(value) && value?.length <= 50) return true

            return 'E-mail must be valid and less than 50 characters.'
          },
        ],
        zipcodeRules: [
          value => {
            if (value) return true

            return 'Zipcode is required.'
          },
          value => {
            if (/^\d{5}$|^\d{5}-\d{4}$/.test(value)) return true;

            return 'Zipcode must be at least 5 numbers.'
          }
        ],
        phoneNumberRules: [
          value => {
            if (value) return true

            return 'Phone number is required.'
          },
          value => {
            if (/^[2-9]\d{2}-\d{3}-\d{4}$/.test(value)) return true;

            return 'Phone number must be in the format 333-444-5555.'
          }
        ],
      }),
    methods: {
        clearErrors() {
          this.registrationErrors = false;
          this.registrationErrorMsg = 'There were problems registering this user.';
        },
        clearInput() {
            this.$refs.registerDoctorForm.reset();
        },
        updateDoctor() {
          DoctorService.updateDoctor(this.doctor.doctorId, this.doctor).then(response => {
            if (response.status === 200) {
              this.$router.push('/');
            }
          });
        }
      },
    created() {
      this.doctor.userId = this.$store.state.doctorToUpdate.userId;
      this.doctor.doctorId = this.$store.state.doctorToUpdate.doctorId;
      this.doctor = this.$store.state.doctorToUpdate;
      console.log('start');
      console.log(this.$store.state.doctorToUpdate);
      console.log('end');
    },
  }
</script>