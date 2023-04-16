<template>
    <v-container fill-height fluid>
      <v-col align="center" justify="center" fill-height class="d-flex justify-center"> 
        <div id="register" class="text-center">
          <v-form ref="registerForm" id="registerForm" v-model="valid" @submit.prevent="register(); registerPatient(); connectIds();">

            <v-text-field
                id="username"
                v-model="user.username"
                :rules="nameRules"
                :counter="50"
                label="Username"
                prepend-inner-icon="mdi-account"
                required
              ></v-text-field>

            <v-text-field 
                type="password"
                id="password"
                v-model="user.password"
                label="Password"
                :counter="20"
                :rules="nameRules"
                prepend-inner-icon="mdi-lock"
                required
            > </v-text-field>

            <v-text-field 
                type="password"
                id="confirmPassword"
                v-model="user.confirmPassword"
                label="Confirm Password"
                :counter="20"
                :rules="nameRules"
                prepend-inner-icon="mdi-lock"
                required
            > </v-text-field>

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


            <v-btn type="submit" :disabled="!valid">Create Account</v-btn>

    
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
import authService from '../services/AuthService';
import patientService from '../services/PatientService'

  export default {
    name: "RegisterForm",
    data: () => ({
        user: {
            username: '',
            password: '',
            confirmPassword: '',
            role: 'user',
        },
        patient: {
          //user.id = thisUserIdNumber
            userId: null,
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
    register() {
      if (this.user.password != this.user.confirmPassword) {
        this.registrationErrors = true;
        this.registrationErrorMsg = 'Password & Confirm Password do not match.';
      } else {
        authService
          .register(this.user)
          .then((response) => {
            if (response.status == 201) {
              this.$router.push({
                path: '/login',
                query: { registration: 'success' },
              });
            }
          })
          .catch((error) => {
            const response = error.response;
            this.registrationErrors = true;
            if (response.status === 400) {
              this.registrationErrorMsg = 'Bad Request: Validation Errors';
            }
          });
          this.patient.userId = patientService.getMaxId();
      }
    },
    clearErrors() {
      this.registrationErrors = false;
      this.registrationErrorMsg = 'There were problems registering this user.';
    },
    clearInput() {
        this.$refs.registerForm.reset();
    },
    registerPatient() {
      patient.userId = this.$store.state.user.id
      patientService.create(this.patient);
    }
    }
  }
</script>