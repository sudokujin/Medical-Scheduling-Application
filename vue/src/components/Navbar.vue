<template>
    <nav>
        <v-app-bar
        app
        color="white"
        >
            <v-app-bar-nav-icon @click="drawer = !drawer"></v-app-bar-nav-icon>
            <span class="font-weight-light">Medical Bros</span>
            <v-spacer></v-spacer>
            <v-icon>icon </v-icon>
        </v-app-bar>
        <v-navigation-drawer app v-model="drawer">
            <v-list-item>
                <v-list-item-content>
                    <v-list-item-title class="text-h6">
                        SideBar
                    </v-list-item-title>
                </v-list-item-content>
            </v-list-item>
            <v-divider></v-divider>
            
            <v-list
                dense
                nav
    
            >
                <v-list-item><router-link class="rl" v-bind:to="{ name: 'home' }">Home</router-link><br></v-list-item>
                <v-list-item><router-link v-bind:to="{ name: 'calendar' }">Calendar</router-link></v-list-item>
                <v-list-item ><router-link class="rl" v-bind:to="{ name: 'reviews' }">Reviews</router-link></v-list-item>
                <v-list-item><router-link class="rl" v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">Logout</router-link></v-list-item>
               
            </v-list>
           
        </v-navigation-drawer>
    </nav>
</template>

<script>

export default {
    name: "nav-bar",
    data() {
        return {
            drawer: false
        }
    }
}
</script>

<style scoped>
    .rl {
        color:black;
    }
</style>
