<template>
<v-container>
  <v-layout>
    <doctor-list />
  </v-layout>
</v-container>
</template>

<script>
import DoctorList from '../components/DoctorList.vue'

export default {
  name: 'home',
  components: {
    DoctorList
  }
}
</script>