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
          v-model="doctors"
          :items="doctors"
          item-text="firstName"
          dense
          outlined
          hide-details
          class="ma-2"
          label="doctors"
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
            :now="today"
            :value="today"
            :events="events"
            color="primary"
            type="week"
            :start="today"
          ></v-calendar>
      </v-sheet>
   </v-container>
    
</template>
<script>
import Navbar from '../components/Navbar.vue'

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
            timeSlots: [],
            today: new Date()
            
        }
    },
    methods: {
        displayTimes() {
            for (let i = 0; i < this.doctors; i++) {
                if (this.doctors[i].firstName === 'Dom'){
                    console.log(this.doctors[i]);
                    this.doc = this.doctors[i];
                    break;
                }
            }
            this.startTime = this.doc.startTime;
            this.endTime = this.doc.endTime;
            
        }
    },
    computed: {
      getNames() {
        let arr = [];
        for (let i = 0; i < this.doctors.length; i++) {
          arr.push(this.doctors[i].firstName);
        }return arr = this.doctorNames;
      }
    },
    created() {
        this.doctors = this.$store.state.doctors
        console.log(this.doctors);
        console.log(this.doctorNames);
        
    }
    
}
    
</script>
