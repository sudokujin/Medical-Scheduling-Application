<template>
   
   <v-container>
   </v-container>
    
</template>
<script>


export default {
    name: 'calendar',
    data() {
        return {
            options: [],
            doctors: this.$store.state.doctors,
            startTime: 0,
            endTime: 0
        }
    },
    methods: {
        // loop over doctor array in vuex store doctors array
            // find which doctor to display based on id/name
            // once find the correct doctor, store that doc obj into obj var
            // create two var - one for start time, one for end time
            // loop over times and increment by 30 min
        displayTimes() {
            let docToDisplay;
            for (let i = 0; i < this.doctors; i++) {
                if (this.doctors[i].firstName === 'Dom'){
                    console.log(this.doctors[i]);
                    docToDisplay = this.doctors[i];
                    break;
                }
            }
            this.startTime = docToDisplay.startTime;
            this.endTime = docToDisplay.endTime;
            
        }
    },
    created() {
        console.log(this.displayTimes());
    }
    
}
    
</script>
