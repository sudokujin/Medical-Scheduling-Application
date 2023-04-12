<template>
<v-container>
  <h1> Doctors </h1>
  <doctor-list />
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