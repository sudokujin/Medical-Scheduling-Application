<template>
<v-container>
  <v-layout>
    <doctor-list v-if="getRolePatient"  />
  </v-layout>
  <v-layout>
    <patient-list v-if="getRoleDoctor" />
  </v-layout>
  <v-layout>
    <admin v-if="getRoleAdmin"/>
  </v-layout>
</v-container>
</template>

<script>
import DoctorList from '../components/DoctorList.vue'
import PatientList from '../components/PatientList.vue'

export default {
  name: 'home',
  components: {
    DoctorList,
    PatientList
  },
  methods: {
    getRoleAdmin() {
      return this.$store.state.user.authorities[0].name === 'ROLE_ADMIN'
    },
    getRolePatient() {
      return this.$store.state.user.authorities[0].name === 'ROLE_USER'
    },
    getRoleDoctor() {
      return this.$store.state.user.authorities[0].name === 'ROLE_DOCTOR'
    }
  },
  created() {
    console.log(this.$store.state.user.authorities[0].name);
  }
}
</script>