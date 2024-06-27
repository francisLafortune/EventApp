<script setup>

import {onMounted, ref} from 'vue'
import EventForm from "@/components/EventForm.vue";
import EventList from "@/components/EventList.vue";
import Modal from "@/components/Modal.vue"

const events = ref([]);
const openedEvent = ref(null);

onMounted(() => {
  //getEvents().then((response) => items.value = response.data);
})

function postEvent(eventRequest) {
  events.value.push(eventRequest)
}

function openModal(eventRequest) {
  openedEvent.value = eventRequest;
}

function closeModal() {
  openedEvent.value = null;
}


</script>


<template>
  <div class="container py-4 px-3 mx-auto">
    <modal v-if="openedEvent" :event="openedEvent" @closeModal="closeModal"></modal>
    <h1>Bienvenue sur la page de création d'événement</h1>
    <event-form @submit="postEvent"></event-form>
    <hr>
    <event-list :events="events" @openModal="openModal"></event-list>
  </div>
</template>