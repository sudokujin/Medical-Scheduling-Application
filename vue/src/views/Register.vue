<template>
    <v-container fill-height fluid>
      <v-col align="center" justify="center" fill-height class="d-flex justify-center"> 
        <div id="register" class="text-center">
          <v-form ref="registerForm" id="registerForm" v-model="valid" @submit.prevent="register();">

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
                path: '/patientInfo',
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
    }
  }
</script>