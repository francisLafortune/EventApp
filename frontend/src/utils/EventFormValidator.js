export function validate(eventForm) {
    const errorBag = [];
    if (eventForm.name === '') {
        errorBag.push("Le nom doit être renseigné.")
    }
    if (eventForm.description === '') {
        errorBag.push("La description doit être renseignée.")
    }
    if (eventForm.beginTime === '' || eventForm.endTime === '') {
        errorBag.push("Les dates de début et de fin doivent être renseignées.")
    } else {
        if (new Date(eventForm.beginTime) > new Date(eventForm.endTime)) {
            errorBag.push("La date de début doit précéder la date de fin.")
        }
    }
    return errorBag;
}