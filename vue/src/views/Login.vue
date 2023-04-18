<template>
  <v-container fill-height fluid>
    <v-col align="center" justify="center" fill-height class="d-flex justify-center">
      <v-card>
      <v-form class="px-6 pb-5 pt-6"  @submit.prevent="login">
        <v-img class='mx-auto' src='../assets/caduceus-transparent-background-8.png'
            max-width='50px'
            max-height='100px'
            > </v-img>
        <h1 >Please Sign In</h1>
          <div role="alert" v-if="invalidCredentials">
            Invalid username and password!
          </div>
          <div role="alert" v-if="this.$route.query.registration">
            Thank you for registering, please sign in.
          </div>
            <v-text-field
              id="username"
              v-model="user.username"
              required
              autofocus
              label="username"
              prepend-inner-icon="mdi-account"
              outlined
              class="mt-4"
            >
            </v-text-field>
            <v-text-field
              type="password"
              id="password"
              v-model="user.password"
              required
              autofocus
              label="password"
              prepend-inner-icon="mdi-lock"
              outlined
              class="mt-4"
            >
            </v-text-field>
            
          <v-btn class="mb-4" type="submit">Sign in</v-btn>
          <p>
            <router-link :to="{ name: 'register' }">Need an account? Sign up.</router-link></p>
          </v-form>
      </v-card>
    </v-col>
  
  </v-container>
</template>

<script>
import authService from "../services/AuthService";

export default {
  name: "login",
  components: {},
  data() {
    return {
      user: {
        username: "",
        password: ""
      },
      invalidCredentials: false
    };
  },
  methods: {
    login() {
      authService
        .login(this.user)
        .then(response => {
          if (response.status == 200) {
            this.$store.commit("SET_AUTH_TOKEN", response.data.token);
            this.$store.commit("SET_USER", response.data.user);
            this.$router.push("/");
          }
        })
        .catch(error => {
          const response = error.response;

          if (response.status === 401) {
            this.invalidCredentials = true;
          }
        });
    }
  }
};
</script>

<style scoped>
.form-input-group {
  margin-bottom: 1rem;
}
label {
  margin-right: 0.5rem;
}
</style>