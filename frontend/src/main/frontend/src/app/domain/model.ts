export const states = ['BACKLOG', 'IN_PROGRESS', 'TEST', 'COMPLETED'];

export interface Tag {
  label: string;
}

export interface Task {
  id?: number;
  title?: string;
  description?: string;
  tags?: Tag[];
  favorite?: boolean;
  state?: string;
}

export const stateGroups = [
  {
    label: 'Planung',
    states: ['BACKLOG']
  },
  {
    label: 'Entwicklung',
    states: ['IN_PROGRESS', 'TEST']
  },
  {
    label: 'In Produktion',
    states: ['COMPLETED']
  }
];

export const stateTexts = {
  'BACKLOG': 'Backlog',
  'IN_PROGRESS': 'In Bearbeitung',
  'TEST': 'Im Test',
  'COMPLETED': 'Abgeschlossen'
};
