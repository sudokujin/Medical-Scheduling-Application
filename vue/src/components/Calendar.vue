<template>
   <v-container>
     <navbar />
     <v-divider></v-divider>
       <h1> Weekly Calendar </h1>
       <v-spacer></v-spacer>
        <v-sheet
            tile
            height="54"
            class="d-flex"
        >
        <v-btn
          icon
          class="ma-2"
          @click="$refs.calendar.prev()"
        >
            <v-icon>mdi-chevron-left</v-icon>
        </v-btn>
        <v-select
          :items="doctors"
          v-model="doctorObj"
          item-text="firstName"
          item-value="id"
          return-object
          dense
          outlined
          hide-details
          class="ma-2"
          label="doctors"
          @change="chosenDoctor"
        ></v-select>
        <v-select
          v-model="mode"
          :items="modes"
          dense
          outlined
          hide-details
          label="event-overlap-mode"
          class="ma-2"
        ></v-select>
        <v-select
          v-model="timeslots"
          :items="times"
          item-text="startTime"
          dense
          outlined
          hide-details
          label="timeslots"
          class="ma-2"
          
        ></v-select>
        <v-spacer></v-spacer>
        <v-btn
          icon
          class="ma-2"
          @click="$refs.calendar.next()"
        >
          <v-icon>mdi-chevron-right</v-icon>
        </v-btn>
      </v-sheet>
      <v-sheet>
        <v-calendar
            ref="calendar"
            
            :value="today"
            
            color="primary"
            type="week"
            :start="today"
          ></v-calendar>
      </v-sheet>
   </v-container>
    
</template>
<script>
import Navbar from '../components/Navbar.vue'
import doctorTimeService from '../services/DoctorTimeService.js'

export default {
    name: 'calendar',
    components: {
      Navbar
    },
    data() {
        return {
            mode: 'stack',
            modes: ['stack', 'column'],
            weekday: [0, 1, 2, 3, 4, 5, 6],
            timeSlots: [1, 2],
            timeSlotByDoctor: [],
            today: new Date(),  
            selected: 0,
        }
    },
    methods: {
        getTimeSlots() {
          doctorTimeService.getAllTimeSlots().then(response => {
          this.$store.commit("SET_TIMESLOTS", response.data);
        });
      },
        chosenDoctor() {
          console.log('testtestest', this.doctorObj);
          this.selected = this.doctorObj.doctorId;
        },
        
    },
    computed: {
      getTimeForDoc() {
        return this.selected;
      }
      // loop over timeslots object to acces start time and end time
        // push first time into timeSlotByDoctor
        // each loop, increment minutes by 30
        // store start time hour and minute in object, and increment those values?
        // concat values back into time format, push into timeSlotByDoctor each iteration
    },
    created() {
        this.getTimeSlots();
        this.doctors = this.$store.state.doctors;
        this.timeSlots = this.$store.state.timeSlots;
        console.log('ID: ', this.selectedId);
        console.log(this.doctorNames);
    }
}
    
</script>