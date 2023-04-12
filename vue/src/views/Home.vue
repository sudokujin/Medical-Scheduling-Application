<template>
  <v-app>
    <v-container>
      <div class="display-4 ma-4 d-flex justify-center">
        All Doctors
      </div>
      <v-data-table
        :items="doctors"
        :headers="headers">
      </v-data-table>
    </v-container>
  </v-app>
</template>

<script>
export default {
  name: "home",
  computed: {
    headers() {
      return [
        {text: 'First Name', value: 'firstName'},
        {text: 'Last Name', value: 'lastName'},
        {text: 'Specialty', value: 'specialty'},
        {text: 'Cost', value: 'costPerHour'},
      ]
    }
  },
  data() {
    return {
      doctors: [
        {firstName: 'Dom', lastName: 'Lorenz', specialty: 'surgeon', costPerHour: 75},
        {firstName: 'Qing', lastName: 'Jin', specialty: 'surgeon', costPerHour: 75},
        {firstName: 'Jordan', lastName: 'Bruntz', specialty: 'surgeon', costPerHour: 75},
        {firstName: 'Youngjin', lastName: 'Kwon', specialty: 'surgeon', costPerHour: 75},
        {firstName: 'Salaj', lastName: 'Choudhary', specialty: 'surgeon', costPerHour: 75},
      ],  
    }
  },
};
</script>
