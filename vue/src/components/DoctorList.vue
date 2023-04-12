<template>
  <div>
      <h1>Doctors</h1>
      <div>
          <table>
              <thead> 
                  <tr>
                      <th>doctor Name</th>
                      <th>specialty</th>
                      <th>Suite Number</th>
                      <th>Cost Per Hour</th>
                  </tr> 
              </thead>
              <tbody>
                  <tr v-for="item in doctors" v-bind:key="item.doctorId">
                      <td>{{item.firstName + item.lastName}}</td>
                      <td>{{item.specialty}}</td>
                      <td>{{item.suiteNumber}}</td>
                      <td>{{item.costPerHour}}</td>
                  </tr>
              </tbody>
          </table>
      </div>
  </div>
</template>

<script>
import doctorService from '../services/DoctorService.js'

export default {
    name: 'doctor-list',
    data() {
        return {
            doctors: []
        }
    },
    created() {
        doctorService.getAllDoctors().then( response => {
            this.doctors = response.data;
        })
    }
}
</script>

<style>

</style>
