<script setup>

import {onMounted, ref} from 'vue'
import EventForm from "@/components/EventForm.vue";
import EventList from "@/components/EventList.vue";

const events = ref([]);


onMounted(() => {
  //getEvents().then((response) => items.value = response.data);
})

function postEvent(eventRequest) {
  events.value.push(eventRequest)
}


</script>


<template>
  <div class="container py-4 px-3 mx-auto">
    <h1>Bienvenue sur la page de création d'événement</h1>
    <event-form @submit="postEvent"></event-form>
    <hr>
    <event-list :events="events"></event-list>
  </div>
</template>