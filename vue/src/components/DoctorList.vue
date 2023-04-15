<template>
  <v-app>
   
      <div class="display-4 ma-4 d-flex justify-center">
        Doctors
      </div>
      <v-data-table
        :items="this.$store.state.doctors"
        :headers="headers"
        >
      </v-data-table>
    
  </v-app>
</template>

<script>
import doctorService from '../services/DoctorService.js';

export default {
  name: "doctor-list",
  computed: {
    headers() {
      return [
        {text: 'First Name', value: 'firstName'},
        {text: 'Last Name', value: 'lastName'},
        {text: 'Specialty', value: 'specialty'},
        {text: 'Suite', value: 'suiteNumber'},
        {text: 'Cost Per Hour', value: 'costPerHour'},
      ]
    }
  },
  methods: {
    getDoctors() {
      doctorService.getAllDoctors().then(response => {
        this.$store.commit("SET_DOCTORS", response.data);
      });
    }
  },
  data() {
    return {
      doctors: [],  
    }
  },
  created() {
      this.getDoctors();
  }
};
</script>