<script setup>

import {onMounted, ref} from 'vue'
import EventForm from "@/components/EventForm.vue";
import EventList from "@/components/EventList.vue";
import Modal from "@/components/Modal.vue"
import {createEvent, getEvents} from "@/services/EventService.js";

const events = ref([]);
const openedEvent = ref(null);
const serverErrorMessage = ref(null);

onMounted(() => {
  initialise();
})

function initialise() {
  getEvents()
      .then((response) => events.value = response.data)
      .catch((error) => {
        handleError(error);
      })
  ;
}

function handleError(error) {
  if (error.response) {
    serverErrorMessage.value = {
      status: error.response.status,
      response: JSON.stringify(error.response.data, null, 2)
    }
  } else {
    serverErrorMessage.value = {
      status: "Unknown error",
      response: ""
    }
  }
}

function postEvent(eventRequest) {
  //events.value.push(eventRequest)
  createEvent(eventRequest).then(() => {
    initialise();
  }).catch((error) => {
    handleError(error);
  })
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
    <div v-if="serverErrorMessage" class="alert alert-danger">
      Error {{ serverErrorMessage.status }}<br>
      {{ serverErrorMessage.response }}
    </div>
    <event-list :events="events" @openModal="openModal"></event-list>

  </div>
</template>