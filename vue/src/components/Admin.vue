<template>
    <v-container>
        <doctor-list />
        <patient-list />
    </v-container>
</template>
<script>
import DoctorList from '../components/DoctorList.vue'
import PatientList from '../components/PatientList.vue'

export default {
    name: 'admin',
    components: {
        DoctorList,
        PatientList
    }
}
</script>
