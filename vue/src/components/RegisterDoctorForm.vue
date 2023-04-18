<template>
    <v-container fill-height fluid>
      <v-col align="center" justify="center" fill-height class="d-flex justify-center"> 
        <div id="registerDoctor" class="text-center">
          <v-card>
          <v-form class="px-6 pb-5 pt-6" ref="registerDoctorForm" id="registerDoctorForm" v-model="valid" @submit.prevent="registerDoctor();">
            <v-img class='mx-auto' src='../assets/caduceus-transparent-background-8.png'
            max-width='50px'
            max-height='100px'
            > </v-img>
            <h1>Please Enter Doctor's Information</h1>
            <v-text-field
                v-model="doctor.firstName"
                :rules="nameRules"
                :counter="50"
                label="First name"
                prepend-inner-icon="mdi-rename"
                required
              ></v-text-field>



            <v-text-field
              v-model="doctor.lastName"
              :rules="nameRules"
              :counter="50"
              label="Last name"
              prepend-inner-icon="mdi-rename"
              required
            ></v-text-field>

            <v-text-field
              v-model="doctor.specialty"
              :rules="nameRules"
              :counter="50"
              label="Specialty"
              prepend-inner-icon="mdi-account-star"
              required
            ></v-text-field>

            <v-text-field
              v-model="doctor.suiteNumber"
              :rules="nameRules"
              :counter="50"
              label="Suite Number"
              prepend-inner-icon="mdi-map-marker"
              required
            ></v-text-field>

            <v-text-field
              v-model="doctor.costPerHour"
              :rules="nameRules"
              :counter="50"
              label="Cost Per Hour"
              prepend-inner-icon="mdi-currency-usd"
              required
            ></v-text-field>

           <v-text-field
              v-model="doctor.phoneNumber"
              :rules="nameRules"
              :counter="50"
              label="Phone Number"
              prepend-inner-icon="mdi-phone"
              required
            ></v-text-field>

            <v-btn type="submit" :disabled="!valid">Submit Doctor Information</v-btn>

    
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
import doctorService from '../services/DoctorService'


  export default {
    name: "DoctorForm",
    data: () => ({
        doctor: {
          //user.id = thisUserIdNumber
            userId: null,
            firstName: '',
            lastName: '',
            specialty: '',
            suiteNumber: '',
            costPerHour: '',
            phoneNumber: '',
        },
        registrationErrors: false,
        registrationErrorMsg: 'There were problems registering this user.',
      valid: false,
      nameRules: [
        value => {
          if (value) return true

          return 'Name is required.'
        },
        value => {
          if (value?.length <= 50) return true

          return 'Name must be less than or equal to 50 characters.'
        },
      ],
      emailRules: [
        value => {
          if (value) return true

          return 'E-mail is required.'
        },
        value => {
          if (/.+@.+\..+/.test(value) && value?.length <= 50) return true

          return 'E-mail must be valid and less than 50 characters.'
        },
      ],
      passwordRules: [
        value => {
          if (value) return true

          return 'Password is required.'
        },
        value => {
          if (/^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$^&*()_-]).{8,20}$/.test(value) && value?.length >= 8 && value?.length <= 20) return true

          return 'Password must be at least between 8 and 20 characters, have one digit, one lower case, one upper case, and one special character.'
        },
      ],
      zipcodeRules: [
        value => {
          if (value) return true

          return 'Zipcode is required.'
        },
        value => {
          if (/^\d{5}$|^\d{5}-\d{4}$/.test(value)) return true;

          return 'Zipcode must be at least 5 numbers.'
        }
      ],
      phoneNumberRules: [
        value => {
          if (value) return true

          return 'Phone number is required.'
        },
        value => {
          if (/^[2-9]\d{2}-\d{3}-\d{4}$/.test(value)) return true;

          return 'Phone number must be in the format 333-444-5555.'
        }
      ],
      dateRules: [
            value => {
          if (value) return true

          return 'Date is required.'
        },
        // eslint-disable-next-line 
        /* eslint-disable */
        value => {
          if (/^\d{4}[\-\/\s]?((((0[13578])|(1[02]))[\-\/\s]?(([0-2][0-9])|(3[01])))|(((0[469])|(11))[\-\/\s]?(([0-2][0-9])|(30)))|(02[\-\/\s]?[0-2][0-9]))$/.test(value)) return true;

          return 'Date must be in format YYYY-MM-DD.'
        }
      ],
    }),
    async created() {
    // make an API call to get the maximum userId value
    const maxUserId = await doctorService.getMaxId();
    // set the userId field in the patient object to the maximum userId value + 1
    this.doctor.userId = maxUserId + 1;
    },
    methods: {
    clearErrors() {
      this.registrationErrors = false;
      this.registrationErrorMsg = 'There were problems registering this user.';
    },
    clearInput() {
        this.$refs.registerDoctorForm.reset();
    },
    registerDoctor() {
    this.doctor.userId = parseInt(this.doctor.userId);
      doctorService.createDoctor(this.doctor);
      
      //this.$router.push("/")
    },
    },
    created() {
       let results =  doctorService.getMaxId();
       console.log(results); 
       console.log(doctorService.getMaxId());
    }
  }
</script>