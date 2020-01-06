import { Component, OnInit } from '@angular/core';
import {FormControl, FormGroup} from '@angular/forms';

@Component({
  selector: 'app-skill',
  templateUrl: './skill.component.html',
  styleUrls: ['./skill.component.css']
})
export class SkillComponent implements OnInit {
  editMode = false;

  skillForm: FormGroup;

  // Backend enums
  difficulties = [];
  abilities = [];

  constructor() { }

  ngOnInit() {
    this.skillForm = new FormGroup(
      {
        name: new FormControl(null),
        difficulty: new FormControl(null),
        ability: new FormControl(null),
        fullSuccess: new FormControl(null),
        success: new FormControl(null),
        failure: new FormControl(null),
        fatalFailure: new FormControl(null)
      }
    );
  }

  onSubmit() {

  }
}
