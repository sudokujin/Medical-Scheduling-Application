<template>
  <v-container>
    <navbar />
    <v-divider></v-divider>
    <h1>Weekly Calendar</h1>
    <v-spacer></v-spacer>
    <div>
      <v-sheet tile height="54" class="d-flex">
        <v-btn icon class="ma-2" @click="$refs.calendar.prev()">
          <v-icon>mdi-chevron-left</v-icon>
        </v-btn>
        <v-select
          v-model="type"
          :items="types"
          dense
          outlined
          hide-details
          class="ma-2"
          label="type"
        ></v-select>
        <v-select
          :items="doctors"
          v-model="doctorObj"
          item-text="firstName"
          item-value="doctorId"
          return-object
          dense
          outlined
          hide-details
          class="ma-2"
          label="doctors"
          @change="chosenDoctor"
        ></v-select>
        <v-select
          v-model="weekday"
          :items="weekdays"
          dense
          outlined
          hide-details
          label="weekdays"
          class="ma-2"
        ></v-select>
        <v-spacer></v-spacer>
        <v-btn icon class="ma-2" @click="$refs.calendar.next()">
          <v-icon>mdi-chevron-right</v-icon>
        </v-btn>
      </v-sheet>
      <v-sheet height="600">
        <v-calendar
          ref="calendar"
          v-model="value"
          :weekdays="weekday"
          :type="type"
          :events="events"
          
          :now="now"
        ></v-calendar>
      </v-sheet>
    </div>
  </v-container>
</template>
<script>
import Navbar from "../components/Navbar.vue";
import AppointmentService from "../services/AppointmentService";

export default {
  name: "calendar",
  components: {
    Navbar,
  },
  data() {
    return {
      type: "month",
      types: ["month", "week", "day"],
      mode: "stack",
      weekday: [0, 1, 2, 3, 4, 5, 6],
      weekdays: [
        { text: "Sun - Sat", value: [0, 1, 2, 3, 4, 5, 6] },
        { text: "Mon - Sun", value: [1, 2, 3, 4, 5, 6, 0] },
        { text: "Mon - Fri", value: [1, 2, 3, 4, 5] },
      ],
      value: "",
      events: [],
      colors: ["blue"],
      names: ["Appointment", "Holiday", "PTO"],
      appointments: [],
      now: '2023-04-20',
      selectedDoctorId: null, // id of doctor,
      doctors: [],
      doctorObj: {}
    };
  },
  methods: {
    chosenDoctor() {
      this.selectedDoctorId = this.doctorObj.doctorId;
    },
    getAppointments() {
      AppointmentService.getAppointments().then((response) => {
        this.$store.commit("SET_APPOINTMENTS", response.data);
        this.appointments = this.$store.state.appointments;
      });
    },
    getEvents() {
      for (let i = 0; i < this.appointments; i++ ) {
        let temp = this.appointments[i];
        let event = {
          name: 'Appointment',
          start: temp.appointmentDate += 'T' + temp.appointmentTime,
          end: temp.appointmentDate += 'T' + temp.appointmentTime.slice(0,2) + '30:00',
          color: 'blue',
          timed: true
        }
        this.events.push(event);
      }
    }
  },
  computed: {
    // This should filter doctor apponintments by id - attached to :events for calendar
    filteredAppointments() {
      return this.$store.state.appointments.filter(
        appt => appt.doctorId === this.selectedDoctorId
      );
    },
  },
  created() {
    this.getAppointments();
    this.doctors = this.$store.state.doctors;
    this.getEvents();
  },
};
</script>