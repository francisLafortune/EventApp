<script setup>

import {onBeforeMount, ref} from "vue";
import {map} from "@/utils/EventMapper.js";
import {validate} from "@/utils/EventFormValidator.js";

const emit = defineEmits(['submit'])

let eventForm = ref({});

let errorBag = ref([]);

function formSubmit() {
  errorBag.value = validate(eventForm.value);
  if (!errorBag.value.length) {
    emit('submit', map(eventForm.value))
    initForm();
  }
}

function initForm() {
  eventForm.value = {
    name: '',
    description: '',
    beginTime: '',
    endTime: ''
  }
}

onBeforeMount(() => {
  initForm();
});


</script>

<template>
  <form class="clearfix" @submit.prevent="onSubmit">
    <div class="mb-3">
      <label class="form-label" for="name">Nom</label>
      <input id="name" v-model="eventForm.name" class="form-control" maxlength="32" type="text">
      <div id="nameHelp" class="form-text">Veuillez saisir un nom descriptif de 32 caractères ou moins.</div>
    </div>
    <div class="mb-3">
      <label class="form-label" for="description">Description</label>
      <textarea id="description" v-model="eventForm.description" class="form-control"></textarea>
    </div>
    <div class="mb-3">
      <label class="form-label" for="beginTime">Début</label>
      <input id="beginTime" v-model="eventForm.beginTime" class="form-control"
             type="datetime-local">
    </div>
    <div class="mb-3">
      <label class="form-label" for="endTime">Fin</label>
      <input id="endTime" v-model="eventForm.endTime" class="form-control"
             type="datetime-local">
    </div>
    <button id="submit-button" class="btn btn-primary float-end" @click="formSubmit">Envoyer</button>
  </form>
  <div v-if="errorBag.length" id="error-wrapper" class="alert alert-warning mt-3">
    <ul id="error-list">
      <li v-for="error in errorBag">{{ error }}</li>
    </ul>
  </div>
</template>