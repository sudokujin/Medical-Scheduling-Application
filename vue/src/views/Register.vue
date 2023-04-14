<template>
    <v-container fill-height fluid>
      <v-col align="center" justify="center" fill-height class="d-flex justify-center"> 
        <div id="register" class="text-center">
          <v-form ref="registerForm" id="registerForm" v-model="valid" @submit.prevent="register(); registerPatient();">

            <v-text-field
                id="username"
                v-model="user.username"
                :rules="nameRules"
                :counter="50"
                label="Username"
                required
              ></v-text-field>

            <v-text-field 
                type="password"
                id="password"
                v-model="user.password"
                label="Password"
                :counter="20"
                :rules="passwordRules"
                required
            > </v-text-field>

            <v-text-field 
                type="password"
                id="confirmPassword"
                v-model="user.confirmPassword"
                label="Confirm Password"
                :counter="20"
                :rules="passwordRules"
                required
            > </v-text-field>

            <v-text-field
                v-model="patient.firstname"
                :rules="nameRules"
                :counter="50"
                label="First name"
                required
              ></v-text-field>



            <v-text-field
              v-model="patient.lastname"
              :rules="nameRules"
              :counter="50"
              label="Last name"
              required
            ></v-text-field>

            <v-text-field
              v-model="patient.email_address"
              :rules="emailRules"
              :counter="50"
              label="E-mail"
              required
            ></v-text-field>

            <v-text-field
              v-model="patient.address"
              :rules="nameRules"
              :counter="100"
              label="Address"
              required
            ></v-text-field>

            <v-text-field
              v-model="patient.city"
              :rules="nameRules"
              :counter="50"
              label="City"
              required
            ></v-text-field>

            <v-text-field
              v-model="patient.state"
              :rules="nameRules"
              :counter="50"
              label="State"
              required
            ></v-text-field>

            <v-text-field
              v-model="patient.zipcode"
              :rules="nameRules"
              :counter="50"
              label="Zipcode"
              required
            ></v-text-field>

            <v-text-field
              v-model="patient.phonenumber"
              :rules="nameRules"
              :counter="50"
              label="Phone Number"
              required
            ></v-text-field>

            <v-text-field
              v-model="patient.birthdate"
              :rules="nameRules"
              :counter="100"
              label="Birth date"
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
            firstname: '',
            lastname: '',
            address: '',
            city: '',
            states: '',
            zipcode: '',
            email_address: '',
            phonenumber: '',
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
          if (value?.length >= 8 && value?.length <= 20) return true

          return 'Password must be at least between 8  and 20 characters.'
        },
      ]
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

    }
    }
  }
</script>