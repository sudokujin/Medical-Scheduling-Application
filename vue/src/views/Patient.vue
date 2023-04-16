<template>
    <v-container fill-height fluid>
      <v-col align="center" justify="center" fill-height class="d-flex justify-center"> 
        <div id="register" class="text-center">
          <v-form ref="registerForm" id="registerForm" v-model="valid" @submit.prevent="registerPatient();">

            <v-text-field
                v-model="patient.firstName"
                :rules="nameRules"
                :counter="50"
                label="First name"
                prepend-inner-icon="mdi-rename"
                required
              ></v-text-field>



            <v-text-field
              v-model="patient.lastName"
              :rules="nameRules"
              :counter="50"
              label="Last name"
              prepend-inner-icon="mdi-rename"
              required
            ></v-text-field>

            <v-text-field
              v-model="patient.emailAddress"
              :rules="nameRules"
              :counter="50"
              label="E-mail"
              prepend-inner-icon="mdi-email"
              required
            ></v-text-field>

            <v-text-field
              v-model="patient.address"
              :rules="nameRules"
              :counter="100"
              label="Address"
              prepend-inner-icon="mdi-map-marker"
              required
            ></v-text-field>

            <v-text-field
              v-model="patient.city"
              :rules="nameRules"
              :counter="50"
              label="City"
              prepend-inner-icon="mdi-city"
              required
            ></v-text-field>

            <v-text-field
              v-model="patient.states"
              :rules="nameRules"
              :counter="50"
              label="State"
              prepend-inner-icon="mdi-map-marker"
              required
            ></v-text-field>

            <v-text-field
              v-model="patient.zipcode"
              :rules="nameRules"
              :counter="50"
              label="Zipcode"
              prepend-inner-icon="mdi-map-marker"
              required
            ></v-text-field>

            <v-text-field
              v-model="patient.patientNumber"
              :rules="nameRules"
              :counter="50"
              label="Phone Number"
              prepend-inner-icon="mdi-phone"
              required
            ></v-text-field>

            <v-text-field
              v-model="patient.birthdate"
              :rules="nameRules"
              :counter="100"
              label="Birth date"
              prepend-inner-icon="mdi-cake"
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
import patientService from '../services/PatientService'

  export default {
    name: "PatientForm",
    data: () => ({
        user: {
            username: '',
            password: '',
            confirmPassword: '',
            role: 'user',
        },
        patient: {
          //user.id = thisUserIdNumber
            userId: patientService.getMaxId(),
            firstName: '',
            lastName: '',
            address: '',
            city: '',
            states: '',
            zipcode: '',
            emailAddress: '',
            patientNumber: '',
            birthdate: '',
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
        this.$refs.registerForm.reset();
    },
    registerPatient() {
      patientService.create(this.patient);
    }
    }
  }
</script>