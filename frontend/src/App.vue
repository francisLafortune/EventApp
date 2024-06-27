<script setup>

import {onMounted, ref} from 'vue'
import EventForm from "@/components/EventForm.vue";

const items = ref('');


onMounted(() => {
  //getEvents().then((response) => items.value = response.data);
})


</script>


<template>
  <div class="container py-4 px-3 mx-auto">
    <h1>Bienvenue sur la page de création d'événement</h1>
    <event-form></event-form>
    <ul class="list-group">
      <li v-for="item in items" class="list-group-item">{{ item.name }}</li>
    </ul>
  </div>
</template>