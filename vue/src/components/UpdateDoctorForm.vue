<template>
    <v-container fill-height fluid>
      <v-col align="center" justify="center" fill-height class="d-flex justify-center"> 
        <div id="registerDoctor" class="text-center">
          <v-form ref="registerDoctorForm" id="registerDoctorForm" v-model="valid" @submit.prevent="registerDoctor();">

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
              label="E-mail"
              prepend-inner-icon="mdi-email"
              required
            ></v-text-field>

            <v-text-field
              v-model="doctor.suiteNumber"
              :rules="nameRules"
              :counter="50"
              label="Zipcode"
              prepend-inner-icon="mdi-map-marker"
              required
            ></v-text-field>

            <v-text-field
              v-model="doctor.costPerHour"
              :rules="nameRules"
              :counter="50"
              label="Phone Number"
              prepend-inner-icon="mdi-phone"
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

            <v-btn type="submit" :disabled="!valid">Submit Patient Information</v-btn>

    
            <v-btn @click="clearInput">
              Clear Fields
            </v-btn>

            <p><router-link :to="{ name: 'login' }">Already have an account? Log in.</router-link></p>
          </v-form>
        </div>
      </v-col>
    </v-container>
</template>

<script>
import doctorService from '../services/DoctorService'
import axios from 'axios';

  export default {
    name: "DoctorForm",
    data: () => ({
        doctor: {
          //user.id = thisUserIdNumber
            userId: 5,
            firstName: '',
            lastName: '',
            specialty: '',
            suiteNumber: '',
            costPerHour: '',
            phoneNumber: '',
            officeHour: '',
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
      passwordRules: [
        value => {
          if (value) return true

          return 'Password is required.'
        },
        value => {
          if (/^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$^&*()_-]).{8,20}$/.test(value) && value?.length >= 8 && value?.length <= 20) return true

          return 'Password must be at least between 8 and 20 characters, have one digit, one lower case, one upper case, and one special character.'
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
      dateRules: [
            value => {
          if (value) return true

          return 'Date is required.'
        },
        // eslint-disable-next-line 
        /* eslint-disable */
        value => {
          if (/^\d{4}[\-\/\s]?((((0[13578])|(1[02]))[\-\/\s]?(([0-2][0-9])|(3[01])))|(((0[469])|(11))[\-\/\s]?(([0-2][0-9])|(30)))|(02[\-\/\s]?[0-2][0-9]))$/.test(value)) return true;

          return 'Date must be in format YYYY-MM-DD.'
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
    registerDoctor() {
    this.doctor.userId = parseInt(patientService.getMaxId());
      doctorService.create(this.doctor);
    },
    async getId() {
        let config = {
            headers: {
                'Accept': 'application/json'
            }
        }
        const response = await axios.get('http://localhost:9000/patients/maxId', config)
        this.response = JSON.parse(response.data.userId);
        console.log(this.response);
    },
    },
    created() {
       let results =  patientService.getMaxId();
       console.log(results); 
       console.log(patientService.getMaxId());
    }
  }
</script>