<template>
  <v-container>
    <v-layout>
      <admin-view v-if="getRoleAdmin" />
      <patient-list v-else-if="getRoleDoctor" />
      <doctor-list v-else />
    </v-layout>
  </v-container>
</template>

<script>
import DoctorList from '../components/DoctorList.vue'
import PatientList from '../components/PatientList.vue'
import AdminView from'../components/AdminView.vue'

export default {
  name: 'home',
  components: {
    DoctorList,
    PatientList,
    AdminView
  },
  computed: {
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