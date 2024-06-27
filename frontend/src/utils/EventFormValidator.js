export function validate(eventForm) {
    if (eventForm.beginTime !== '' && eventForm.endTime !== '') {
        return new Date(eventForm.beginTime) < new Date(eventForm.endTime);
    }
    return true;
}