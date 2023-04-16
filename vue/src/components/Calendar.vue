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
          @click="createTimeSlots"
          @change="chosenDoctor"
        ></v-select>
        <v-select
          v-model="timeSlotByDoctor"
          :items="timeSlotByDoctor"
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
            v-model: selectedDate
            :now="now"
            color="primary"
            type="week"
            
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
            weekday: [0, 1, 2, 3, 4, 5, 6],
            timeSlots: [],
            timeSlotByDoctor: [],
            now: new Date(),
            selected: null, // id of doctor,
            selectedDate: null,
            appointment: {
              patientId: 0,
              doctorId: '',
              appointmentDuration: 30,
              description: '',
              appointmentDate: '2023-04-16',
              appointmentTime: '08:00:00'
            }
        }
    },
    methods: {
        getTimeSlots() {
          doctorTimeService.getAllTimeSlots().then(response => {
          this.$store.commit("SET_TIMESLOTS", response.data);
        });
        },
          chosenDoctor() {
          this.selected = this.doctorObj.doctorId;
//this.timeSlots.length
          for (let i = 0; i < 10; i++) {
//if (this.timeSlots[i].doctorId === this.selected) {
              this.timeSlotByDoctor.push(i);
    //        }
          }
          
        },
        // createTimeSlots() {
        //   let current = this.timeSlots.filter( timeObj => timeObj.doctorId === this.selected);
          
        //   if (current.doctorId === this.selected) {
        //     for (let i = 8; i < 16; i++) {
        //       this.timeSlotByDoctor.push(i);
        //     }
        //   }
        // }
    },
    computed: {
      
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
    },
    
    
}
    
</script>