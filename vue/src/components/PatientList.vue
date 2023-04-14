<template>
    <v-app>
   
      <div class="display-4 ma-4 d-flex justify-center">
        Patients
      </div>
      <v-data-table
        :items="patients"
        :headers="headers"
        >
      </v-data-table>
  </v-app>
</template>

<script>
import patientService from '../services/PatientService.js';

export default {
  name: "patient-list",
  computed: {
    headers() {
      return [
        {text: 'First Name', value: 'firstName'},
        {text: 'Last Name', value: 'lastName'},
        {text: 'Email Address', value: 'emailAddress'},
        {text: 'City', value: 'city'},
        {text: 'State', value: 'states'},
      ]
    }
  },
  data() {
    return {
      patients: [],  
    }
  },
  created() {
      patientService.getPatientList().then(response => {
      this.doctors = response.data;
    })
  }
};
</script>

