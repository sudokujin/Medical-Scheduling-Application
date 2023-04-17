<template>
  <v-app>
    
    <v-main>
      <router-view/>
    </v-main>
  </v-app>
</template>

<script>

export default {
  name: 'App',
  data() {
    return {
      
    }
  }
};
</script>

<style >
  #app {
    background-color: #CBC6C7;
  }

  .v-data-table .v-data-table-header tr th {
  font-size: 24px !important;
}
  
</style>
