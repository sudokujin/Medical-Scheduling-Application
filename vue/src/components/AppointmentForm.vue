/* eslint-disable */
<template>
 <v-container fill-height fluid>
   <navbar />
      <v-col align="center" justify="center" fill-height class="d-flex justify-center"> 
        <div id="appointment" class="text-center">
          <v-card  >
          <v-form class="px-6 pb-5 pt-6" ref="appointmentForm" id="appointmentForm" v-model="valid" @submit.prevent="createAppointment">
            <v-text-field
              v-model="appointment.appointmentDate"
              
              :counter="100"
              label="Appointment Date"
              prepend-inner-icon="mdi-cake"
              required
            ></v-text-field>
            <v-select
              :items="this.$store.state.doctors"
              v-model="doctorObj"
              item-text="firstName"
              item-value="id"
              return-object
              dense
              outlined
              hide-details
              class="ma-2 pb-6"
              label="doctors"
              @change="chosenDoctor"
            ></v-select>

            <v-select
              :items="timeslots"
              v-model="time"
              item-text=""
              item-value="id"
              return-object
              dense
              outlined
              hide-details
              class="ma-2 pb-6"
              label="timeslots"
              
            ></v-select>
            <v-text-field
              v-model="appointment.description"
                :counter="100"
                label="Description"
                required>
            </v-text-field>

            <v-btn type="submit" :disabled="!valid">Create Appointment</v-btn>
            <v-btn @click="clearInput">
              Clear Fields
            </v-btn>

          </v-form>
          </v-card>
        </div>
      </v-col>
    </v-container>
</template>

<script>
import AppointmentService from '../services/AppointmentService'
import Navbar from '../components/Navbar.vue'
import DoctorTimeService from '../services/DoctorTimeService'


export default {
    name: 'AppointmentForm',
    components: {
      Navbar
    },
    data: () => ({
                  appointment: {
                    patientId: 0,
                    doctorId: null,
                    appointmentDuration: 30,
                    description: '',
                    appointmentDate: '',
                    appointmentTime: ''
                  },
                    timeslots: [],
                    valid: false,
                    selected: null, 
                    dateSelected: null,
                    dateRules: [
                    value => {
                        if (value) return true

                        return 'Date is required.'
                    },
                      // eslint-disable-next-line 
                      /* eslint-disable */
                      value => {
                        if (/^\d{4}[\-\/\s]?((((0[13578])|(1[02]))[\-\/\s]?(([0-2][0-9])|(3[01])))|(((0[469])|(11))[\-\/\s]?(([0-2][0-9])|(30)))|(02[\-\/\s]?[0-2][0-9]))$/.test(value)) return true;

                        return 'Date must be in the format YYYY-MM-DD.'
                      }
                    ],
                    timeRules: [
                                  value => {
                        if (value) return true

                        return 'Time is required.'
                      },
                    value => {
                        if (/(([0-1][0-9])|([2][0-3])):([0-5][0-9]):([0-5][0-9])/.test(value)) return true;

                        return 'Time must be in the format 00:00:00.'
                      }
                    ]
                          
                  }),
                  methods: {
                    clearInput() {
                      this.$refs.appointmentForm.reset();
                  },
                    createAppointment() {
                      AppointmentService.createAppointment(this.appointment).then(response => {
                        if (response.status === 201) {
                          this.getTimeslots();
                        }
                      })
                      this.$router.push('/');
                    },
                    getTimeSlotByIdAndDate(id, date) {
                      AppointmentService.getTimeArray(id, date).then(response => {
                        this.timeSlots = response.data;
                      });
                      // service call here to pull data from doctor based on id this.selected and date selected this.dateSelected
                      // will i need to add a list of dates as well as a dropdown menu?
                    },
                    chosenDoctor() {
                        this.appointment.doctorId = this.doctorObj.doctorId;
                        DoctorTimeService.getTimeArray(this.appointment.doctorId, this.appointment.appointmentDate).then(response => {
                        this.timeSlots = response.data;
                      });          
                      },
                    },
                    created() {
                      // AppointmentService.getTimeArray(this.appointment.doctorId, this.appointment.appointmentDate).then(response => {
                      //   this.timeSlots = response.data;
                      // });
                    }
}

</script>
