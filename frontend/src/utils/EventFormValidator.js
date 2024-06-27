export function validate(eventForm) {
    return new Date(eventForm.beginTime) < new Date(eventForm.endTime);
}