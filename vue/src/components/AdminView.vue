<template>
<v-container fill-height fluid>
  <h1 class="mb-6">Admin View</h1>
  <v-row
      justify="center">
      <v-col class="mx-16 px-16">
      <v-divider> </v-divider>
      <div class="display-1 ma-4 d-flex justify-center">
        Doctors
      </div>
      
      <v-card >
          
      <v-data-table
        :items="this.$store.state.doctors"
        :headers="headers"
        hide-default-footer
        v-model="doctorObj"
        item-key="id"
        >
        <template v-slot:[`item.action`]="{item}">
            <v-icon @click="updateDoctor(); getDocById(item.doctorId)">mdi-pencil-circle-outline</v-icon>
            <v-icon @click="removeDoctor(item.doctorId)">mdi-trash-can-outline</v-icon>
         </template>
      </v-data-table>
      </v-card >
      <v-btn
       class="mt-3"
       @click="getItem()"
       >
        Add Doctor
      </v-btn>
      
      </v-col>
  </v-row>
</v-container>
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
        {text: '', value: 'action'}
     
      ]
    }
  },
  methods: {
    updateDoctor() {
      this.$router.push('/updateDoctor');
    },
    getDoctors() {
      doctorService.getAllDoctors().then(response => {
        this.$store.commit("SET_DOCTORS", response.data);
      });
    },
    getItem() {
      this.item = '';
      this.$router.push({name: 'doctorAccount'})
    },
    removeDoctor(id) {
      doctorService.deleteDoctor(id).then(response => {
        if (response.status === 200) {
          this.getDoctors();
        }
      })
    },
    getDocById(id) {
      doctorService.get(id).then(response => {
        this.$store.commit("SET_DOCTORTOUPDATE", response.data);
      });
    }
  },
  data() {
    return {
      doctors: [],  
      item: 'hello',

    }
  },
  created() {
      this.getDoctors();
  },
  

};
</script>
<style scoped>

</style>