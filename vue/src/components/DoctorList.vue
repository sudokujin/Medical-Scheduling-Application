<template>
<v-container fill-height fluid>
  
  <v-row
      justify="center">
      <v-col class="mx-16 px-16">
      <h1 class="mb-6">Welcome, Patient!</h1>
      <v-divider class="mb-16"> </v-divider>
      
      <v-card
      max-width="400"
      flat
      class="mb-6"
      >
        <v-card-title> {{this.officeInfo.officeName}} </v-card-title>
        <v-card-text>
          <p> {{this.officeInfo.mainAddress}} </p>
          <p> {{this.officeInfo.cityState}}</p>
          <p> {{this.officeInfo.mainPhone}}</p>
      </v-card-text>
      </v-card>
      <div class="display-1 ma-2 mt-16">
        Available Doctors
      </div>
      <v-card >
      <v-data-table
        :items="this.$store.state.doctors"
        :headers="headers"
        hide-default-footer
        
        >

      </v-data-table>
      </v-card >
      <v-btn
       class="mt-3"
       @click="getItem()"
       >
        Book Appointment
      </v-btn>
      
      </v-col>
  </v-row>
</v-container>
</template>

<script>
import doctorService from '../services/DoctorService.js';
import patientService from '../services/PatientService.js'

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
        {text: 'Phone Extension', value: 'phoneNumber'},
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
    },
    // sets current patient object in vuex
    getPatientInfo() {
      patientService.getPatientByUserId(this.$store.state.user.id).then(response => {
        this.$store.commit("SET_PATIENT", response.data);
      });
    }
  },
  data() {
    return {
      doctors: [],  
      userId: 0,
      officeInfo: {
        officeName: "Party Doctors United",
        mainAddress: "1420 Savelives st",
        cityState: "Phoenix, AZ",
        mainPhone: "800-500-1212"
      }
    }
  },
  created() {
      this.getDoctors();
      patientService.getPatientByUserId(this.$store.state.user.id).then(response => {
        console.log('hi', response);
        this.$store.commit("SET_PATIENT", response.data);
      })
      // this.getPatientInfo();
      
  }
};
</script>
<style scoped>

</style>