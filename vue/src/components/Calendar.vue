<template>
   <v-container>
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
          @click="insertSomethingHere"
        >
          <v-icon>mdi-chevron-right</v-icon>
        </v-btn>
      </v-sheet>
      <v-sheet>
        <v-calendar-weekly
            ref="calendar"
            :weekdays="weekday"
        >
            
        </v-calendar-weekly>
      </v-sheet>
   </v-container>
    
</template>
<script>


export default {
    name: 'calendar',
    data() {
        return {
            type: 'week',
            mode: 'stack',
            modes: ['stack', 'column'],
            weekday: [1, 2, 3, 4, 5],
            selectedDate: new Date(),
            timeSlots: [],
            doctor: '',
            doctors: ['Dom', 'Salaj', 'Youngjin'],
            startTime: 0,
            endTime: 0
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
            
        },
        getDocName() {
          for (let i = 0; i < this.$store.state.doctors.length; i++) {
            console.log(this.doctors[i].firstName);
          }
        }
    },
    created() {
        console.log(this.doctors);
        console.log('hello');
        console.log(this.getDocName());
    }
    
}
    
</script>
