<template>
  <v-app>
    <v-container>
      <div class="display-4 ma-4 d-flex justify-center">
        All Doctors
      </div>
      <v-data-table
        :items="doctors"
        :headers="headers"
        >
      </v-data-table>
    </v-container>
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
        {text: 'Cost', value: 'costPerHour'},
      ]
    }
  },
  data() {
    return {
      doctors: [],  
    }
  },
  created() {
      doctorService.getAllDoctors().then(response => {
      this.doctors = response.data;
    })
  }
};
</script>