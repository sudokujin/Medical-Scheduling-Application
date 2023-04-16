<template>
  <v-app>
   
      <div class="display-4 ma-4 d-flex justify-center">
        Doctors
      </div>
      <v-data-table
        :items="this.$store.state.doctors"
        :headers="headers"
        >
        <template v-slot:[`item.action`]="{item}">
          <v-btn @click="getItem(item)">Schedule Appointment</v-btn>
        </template>
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
        {text: 'Schedule Appointment', value: 'action'}
      ]
    }
  },
  methods: {
    getDoctors() {
      doctorService.getAllDoctors().then(response => {
        this.$store.commit("SET_DOCTORS", response.data);
      });
    },
    getItem() {
      this.item = '';
      this.$router.push({name: 'doctor'})
    }
  },
  data() {
    return {
      doctors: [],  
      item: 'hello'
    }
  },
  created() {
      this.getDoctors();
  }
};
</script>