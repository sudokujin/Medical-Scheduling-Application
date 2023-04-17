<template>
    <nav>
        <v-app-bar
        app
        color="grey"
        >
            <v-app-bar-nav-icon @click="drawer = !drawer"></v-app-bar-nav-icon>
            <span class="font-weight-light">Medical Bros</span>
            <v-spacer></v-spacer>
            <router-link class="rl" v-bind:to="{ name: 'home' }">Home</router-link>&nbsp;|&nbsp;
            <router-link class="rl" v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">Logout</router-link>
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
            <v-list-item>
                <router-link v-bind:to="{ name: 'calendar' }">Calendar</router-link>&nbsp;|&nbsp;
            </v-list-item>
            <v-list-item>link 2</v-list-item>
            <v-list-item>link 3</v-list-item>
            <v-list-item>link 4</v-list-item>
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
