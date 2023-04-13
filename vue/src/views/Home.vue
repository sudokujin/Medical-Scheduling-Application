<template>
<v-container>
  <v-layout>
    <doctor-list v-if="role = user" />
    <patient-list v-if="role = doctor" />
    <admin v-if="role = admin"/>
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
}
</script>